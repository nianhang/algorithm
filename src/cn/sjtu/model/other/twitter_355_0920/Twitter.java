package cn.sjtu.model.other.twitter_355_0920;

import java.util.*;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-20 17:57
 * @description：设计推特
 */

public class Twitter {

    private static int timestamp = 0;
    //Tweet 类必须要用到一个全局时间戳 timestamp
    private static class Tweet{

        private int id;
        private int time;
        private Tweet next;

        public Tweet(int id,int time){
            this.id = id;
            this.time = time;
            this.next = null;
        }
    }
    //User 类又需要用到 Tweet 类记录用户发送的推文
    private static class User{

        private int id;

        public Set<Integer> followed;
        //用户发表的推文链表头节点
        public Tweet head;

        public User(int userId){
            followed = new HashSet<>();
            this.id = userId;
            this.head = null;
            follow(id);
        }

        public void follow(int userId){
            followed.add(userId);
        }

        public void unfollow(int userId){
            //不能取关自己
            if(userId != this.id){
                followed.remove(userId);
            }
        }
        public void post(int tweetId){
            Tweet twt = new Tweet(tweetId,timestamp);
            timestamp++;
            //将新建的推文插入链表头
            //越靠前的推文time值越大
            twt.next = head;
            head = twt;
        }
    }

    //需要一个映射将userId和user对象对应起来
    private HashMap<Integer,User> userMap = new HashMap<>();

    /** Initialize your data structure here. */
    public Twitter() {

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId)){
            userMap.put(userId,new User(userId));
        }
        User u = userMap.get(userId);
        u.post(tweetId);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    //返回该user关注的人（包括他自己）最近的动态Id，
    //最多10条，而且这些动态必须按照从新到旧的时间线顺序排列
    //合并K个有序链表
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if(!userMap.containsKey(userId)) return res;
        //关注列表的用户Id
        Set<Integer> users = userMap.get(userId).followed;
        //自动通过time属性从大到小排序，容量为users的大小
        PriorityQueue<Tweet> pq =
                new PriorityQueue<>(users.size(),(a,b)->(b.time - a.time));

        //先将所有链表头节点插入优先级队列
        for(int id : users){
            Tweet twt = userMap.get(id).head;
            if(twt == null) continue;
            pq.add(twt);
        }

        while(!pq.isEmpty()){
            //最多返回10条
            if(res.size() == 10) break;

            Tweet twt = pq.poll();
            res.add(twt.id);
            //将下一篇Tweet插入进行排序
            if(twt.next != null){
                pq.add(twt.next);
            }
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        //如果follower不存在，则新建
        if(!userMap.containsKey(followerId)){
            User u = new User(followerId);
            userMap.put(followerId,u);
        }
        //如果followee不存在，则新建
        if(!userMap.containsKey(followeeId)){
            User u = new User(followeeId);
            userMap.put(followeeId,u);
        }
        userMap.get(followerId).follow(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(userMap.containsKey(followerId)){
            User follower = userMap.get(followerId);
            follower.unfollow(followeeId);
        }
    }
}

package cn.sjtu.model.other.twitter_355_0920;

import java.util.*;

/**
 * @author ��linfd
 * @version :$
 * @date ��Created in 2021-09-20 17:57
 * @description���������
 */

public class Twitter {

    private static int timestamp = 0;
    //Tweet �����Ҫ�õ�һ��ȫ��ʱ��� timestamp
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
    //User ������Ҫ�õ� Tweet ���¼�û����͵�����
    private static class User{

        private int id;

        public Set<Integer> followed;
        //�û��������������ͷ�ڵ�
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
            //����ȡ���Լ�
            if(userId != this.id){
                followed.remove(userId);
            }
        }
        public void post(int tweetId){
            Tweet twt = new Tweet(tweetId,timestamp);
            timestamp++;
            //���½������Ĳ�������ͷ
            //Խ��ǰ������timeֵԽ��
            twt.next = head;
            head = twt;
        }
    }

    //��Ҫһ��ӳ�佫userId��user�����Ӧ����
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
    //���ظ�user��ע���ˣ��������Լ�������Ķ�̬Id��
    //���10����������Щ��̬���밴�մ��µ��ɵ�ʱ����˳������
    //�ϲ�K����������
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if(!userMap.containsKey(userId)) return res;
        //��ע�б���û�Id
        Set<Integer> users = userMap.get(userId).followed;
        //�Զ�ͨ��time���ԴӴ�С��������Ϊusers�Ĵ�С
        PriorityQueue<Tweet> pq =
                new PriorityQueue<>(users.size(),(a,b)->(b.time - a.time));

        //�Ƚ���������ͷ�ڵ�������ȼ�����
        for(int id : users){
            Tweet twt = userMap.get(id).head;
            if(twt == null) continue;
            pq.add(twt);
        }

        while(!pq.isEmpty()){
            //��෵��10��
            if(res.size() == 10) break;

            Tweet twt = pq.poll();
            res.add(twt.id);
            //����һƪTweet�����������
            if(twt.next != null){
                pq.add(twt.next);
            }
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        //���follower�����ڣ����½�
        if(!userMap.containsKey(followerId)){
            User u = new User(followerId);
            userMap.put(followerId,u);
        }
        //���followee�����ڣ����½�
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

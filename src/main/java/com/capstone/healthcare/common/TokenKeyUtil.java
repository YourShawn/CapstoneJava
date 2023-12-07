package com.capstone.healthcare.common;

public class TokenKeyUtil {


    public static String USER_REDIS_INFO_DIRE = "user:info:";
    public static String BLOCKCHAIN_REDIS_LOGIN_ID2TOKEN_DIRE = "blockchain:login:id2token:";
    public static String BLOCKCHAIN_REDIS_LOGIN_TOKEN2INFO_DIRE = "blockchain:login:token2info:";

    public static String BLOCKCHAIN_ADMIN_LOGIN_ID2TOKEN_DIRE = "blockchain:admin:login:id2token:";
    public static String BLOCKCHAIN_ADMIN_LOGIN_TOKEN2INFO_DIRE = "blockchain:admin:login:token2info:";


    public static String BLOCKCHAIN_REDISLOCK_USERID_BILL = "blockchain:userId:bill:";
    public static String BLOCKCHAIN_REDISLOCK_USERID_ACCOUNT = "blockchain:userId:account:";
    public static String BLOCKCHAIN_REDISLOCK_USERID_BINA = "blockchain:userId:bina:";
    public static String BIZ_ID_COUNTER = "biz:id:counter:";

    public static String ORDER_BIZ_ID_COUNTER = "orderBizId";


    public static String ORDER_CALLBACK_FLAG = "order:callback:flag:";
    public static String STAKE_OPEN_FLAG = "stakes:open:flag:";

    public static String BTC_ZSET = "Binance:btcusdt";




    public static String userInfoKey(String token) {
        return USER_REDIS_INFO_DIRE+token;
    }

    public static String blockchainLoginToken2Info(String token) {
        return BLOCKCHAIN_REDIS_LOGIN_TOKEN2INFO_DIRE +token;
    }
    public static String blockchainLoginId2Token(Long adminId) {
        return BLOCKCHAIN_REDIS_LOGIN_ID2TOKEN_DIRE +adminId;
    }


    public static String adminLoginId2Token(Long adminId) {
        return BLOCKCHAIN_ADMIN_LOGIN_ID2TOKEN_DIRE +adminId;
    }
    public static String adminLoginToken2Info(String token) {
        return BLOCKCHAIN_ADMIN_LOGIN_TOKEN2INFO_DIRE +token;
    }

    public static String redisLockBillUserId(String userId) {
        return BLOCKCHAIN_REDISLOCK_USERID_BILL +userId;
    }

    public static String redisLockUserAccount(String userId) {
        return BLOCKCHAIN_REDISLOCK_USERID_ACCOUNT +userId;
    }

    public static String redisLockUserBina(String userId) {
        return BLOCKCHAIN_REDISLOCK_USERID_BINA +userId;
    }

    public static String redisBizIdCounter(String bizId) {
        return BIZ_ID_COUNTER + bizId;
    }

    public static String redisBizIdFlag(String bizId) {
        return ORDER_CALLBACK_FLAG + bizId;
    }

    public static String redisOpenAroundFlag(String stakeId) {
        return STAKE_OPEN_FLAG + stakeId;
    }
}

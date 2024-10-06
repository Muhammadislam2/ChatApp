package com.example.whatsapp.Models;

public class ChatModel {
        int userImage;
        String userName,userLastMsg,msgTime;

        public ChatModel(int userImage, String userName, String userLastMsg, String msgTime) {
                this.userImage = userImage;
                this.userName = userName;
                this.userLastMsg = userLastMsg;
                this.msgTime = msgTime;
        }

        public int getUserImage() {
                return userImage;
        }

        public void setUserImage(int userImage) {
                this.userImage = userImage;
        }

        public String getUserName() {
                return userName;
        }

        public void setUserName(String userName) {
                this.userName = userName;
        }

        public String getUserLastMsg() {
                return userLastMsg;
        }

        public void setUserLastMsg(String userLastMsg) {
                this.userLastMsg = userLastMsg;
        }

        public String getMsgTime() {
                return msgTime;
        }

        public void setMsgTime(String msgTime) {
                this.msgTime = msgTime;
        }
}

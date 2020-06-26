package com.letchic.views;

public interface ChatMessageView {
    long getMessageid();
    long getUseridfrom();
    long getUseridto();
    String getMessage();
    String getDate();
    String getUserfiofrom();
    String getUserfioto();
}

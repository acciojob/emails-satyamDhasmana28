package com.driver;


import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Gmail extends Email {

    int inboxCapacity; //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)

    LinkedList<Mail> Inbox;
    LinkedList<Mail> Trash;
    public Gmail(String emailId, int inboxCapacity) {
     super(emailId);
     this.inboxCapacity = inboxCapacity;
     Inbox = new LinkedList<>();
     Trash = new LinkedList<>();
    }

    public boolean isFull(){
        return Inbox.size()==this.inboxCapacity;
    }
    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.
        if(!isFull()){
           Inbox.add(new Mail(date,sender,message));
        }
        else{
            Mail oldestMail = Inbox.removeFirst();
            Trash.add(oldestMail);
            Inbox.add(new Mail(date,sender,message));
        }
    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
        for(Mail mail : Inbox){
            if(mail.message==message){
                Inbox.remove(mail);
            }
        }
    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
        Mail last = Inbox.peekLast();
        if(last != null){
            return last.message;
        }
        return "null";
    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        Mail oldest = Inbox.peekFirst();
        if(oldest != null){
            return oldest.message;
        }
        return "null";
    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
        int noOfMail=1;
        if(Inbox.isEmpty()) {
            return noOfMail;
        }

        else{
           for(Mail mail : this.Inbox){
               if(mail.date.compareTo(start)>=0 && mail.date.compareTo(end)<=0){
                   ++noOfMail;
               }
           }
        }
        return  noOfMail;
    }

    public int getInboxSize(){
        // Return number of mails in inbox
        return Inbox.size() ;
    }

    public int getTrashSize(){
        // Return number of mails in Trash
        return  Trash.size();
    }

    public void emptyTrash(){
        // clear all mails in the trash
       Trash.clear();
    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return  this.inboxCapacity;
    }
}

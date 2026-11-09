package com.school;
import com.school.observer.*;import org.junit.jupiter.api.Test;import static org.junit.jupiter.api.Assertions.*;
class ObserverTest {@Test void deliversNotifications(){var publisher=new GradePublisher();var observer=new StudentNotificationObserver();publisher.subscribe(observer);publisher.publish("s1","c1",95);assertEquals(1,observer.messagesFor("s1").size());assertTrue(observer.messagesFor("s2").isEmpty());}}

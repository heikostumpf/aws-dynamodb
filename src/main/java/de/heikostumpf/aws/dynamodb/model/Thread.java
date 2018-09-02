package de.heikostumpf.aws.dynamodb.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import org.springframework.data.annotation.Id;

/**
 * @author Heiko Stumpf <github.com/heikostumpf>
 * @version 1.0
 *
 * This entity represents the Thread table implementation described
 * in the AWS DynamoDB developer guide. It represents the usage of a
 * composite primary key.
 *
 * @see https://docs.aws.amazon.com/de_de/amazondynamodb/latest/developerguide/WorkingWithDynamo.html
 *
 */
@DynamoDBTable(tableName = "Thread")
public class Thread {

    @Id
    private ThreadId threadId;

    @DynamoDBHashKey(attributeName = "ForumName")
    public String getForumName() {
        return threadId.getForumName();
    }

    public void setForumName(String forumName) {
        threadId.setForumName(forumName);
    }

    @DynamoDBRangeKey(attributeName = "Subject")
    public String getSubject() {
        return threadId.getSubject();
    }

    public void setSubject(String subject) {
        threadId.getSubject(subject);
    }

    @Override
    public String toString() {
        return "Thread{" +
                "forumName='" + threadId.getForumName() + '\'' +
                ", subject='" + threadId.getSubject() + '\'' +
                '}';
    }
}

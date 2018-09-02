package de.heikostumpf.aws.dynamodb.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;

import java.io.Serializable;

/**
 * @author Heiko Stuompf
 * @version 1.0
 *
 * This key class represents the composite primary key (partition- & sort key)
 * of the Thread table implementation described in the AWS Dynamo
 * developer guide.
 *
 * @see https://docs.aws.amazon.com/de_de/amazondynamodb/latest/developerguide/WorkingWithDynamo.html
 *
 */
public class ThreadId implements Serializable{

    private static final long serialVersionUID = 1L;

    private String forumName;

    private String subject;

    @DynamoDBHashKey
    public String getForumName() {
        return forumName;
    }

    public void setForumName(String forumName) {
        this.forumName = forumName;
    }

    @DynamoDBRangeKey
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

}

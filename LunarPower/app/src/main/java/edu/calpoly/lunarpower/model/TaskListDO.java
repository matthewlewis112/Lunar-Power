package edu.calpoly.lunarpower.model;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

import java.util.List;

@DynamoDBTable(tableName = "lunarpower-mobilehub-627565767-TaskList")

public class TaskListDO {
    private String userId;
    private List<String> tasks;
    private Double time;

    @DynamoDBHashKey(attributeName = "userId")
    @DynamoDBAttribute(attributeName = "userId")
    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }
    @DynamoDBAttribute(attributeName = "Tasks")
    public List<String> getTasks() {
        return tasks;
    }

    public void setTasks(final List<String> tasks) {
        this.tasks = tasks;
    }
    @DynamoDBAttribute(attributeName = "Time")
    public Double getTime() {
        return time;
    }

    public void setTime(final Double time) {
        this.time = time;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(tasks != null) {
            int index = 0;
            while (index < tasks.size()) {
                sb.append(tasks.get(index)).append("\n");
                index++;
            }
        }
        return sb.toString();
    }

}

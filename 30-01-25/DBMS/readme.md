
---

# 1683. Invalid Tweets

## Problem Description

The goal of this problem is to identify invalid tweets from a social media platform based on the length of the tweet content. A tweet is considered invalid if the number of characters in the tweet's content is strictly greater than 15.

### Table Schema:

**Table: Tweets**

| Column Name  | Type      |
|--------------|-----------|
| tweet_id     | int       |
| content      | varchar   |

- `tweet_id`: The unique identifier for each tweet (Primary Key).
- `content`: The content of the tweet, which consists of characters on an American Keyboard (no special characters).

### Problem Task:
You are required to find the tweet IDs of invalid tweets, where the content's length is greater than 15 characters.

### Expected Output:

- Return the `tweet_id` for all invalid tweets, which are those whose `content` has more than 15 characters.
- The result can be returned in any order.

## Solution

```sql
SELECT tweet_id
FROM tweets
WHERE CHAR_LENGTH(content) > 15;
```

### Explanation:

- The `CHAR_LENGTH(content)` function is used to count the number of characters in the `content` column.
- We filter the results by selecting only those rows where the `content` length is greater than 15, which are considered invalid tweets.

## How to Run:

1. Save the SQL query and execute it against a SQL database with the `Tweets` table schema.
2. Ensure that the table contains data with different tweet lengths.
3. The query will return all the `tweet_id`s where the tweet content length exceeds 15 characters.

---

### README: Find Followers Count

#### Problem Overview
In a social media application, we are provided with a table named `Followers`, which records the relationship between users and their followers. Each row contains the `user_id` (the user being followed) and `follower_id` (the user who is following). The task is to return the number of followers for each user, ordered by `user_id` in ascending order.

#### SQL Query

```sql
SELECT user_id, COUNT(follower_id) AS followers_count
FROM Followers
GROUP BY user_id
ORDER BY user_id;
```

#### Explanation:
- **`COUNT(follower_id)`**: This function counts the number of followers for each user.
- **`GROUP BY user_id`**: This clause groups the data by the `user_id`, ensuring the count is calculated separately for each user.
- **`ORDER BY user_id`**: This orders the result by `user_id` in ascending order.

#### Example

Given the input:

| user_id | follower_id |
|---------|-------------|
| 0       | 1           |
| 1       | 0           |
| 2       | 0           |
| 2       | 1           |

The output will be:

| user_id | followers_count |
|---------|-----------------|
| 0       | 1               |
| 1       | 1               |
| 2       | 2               |

#### Explanation of Output:
- **User 0** has 1 follower: `follower_id = 1`.
- **User 1** has 1 follower: `follower_id = 0`.
- **User 2** has 2 followers: `follower_id = 0, 1`.

#### Conclusion
This solution calculates and returns the number of distinct followers for each user, ordered by the `user_id`. It efficiently aggregates the follower data to provide insights into each user's follower count.
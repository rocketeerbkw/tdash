SELECT version from meta_info;
\prompt "Did you see 13 above? If no, press Ctrl+c now!" correctVersion

ALTER TABLE oauth_tokens ALTER COLUMN user_id TYPE bigint;
ALTER TABLE uploads ALTER COLUMN user_id TYPE bigint;
ALTER TABLE users ALTER COLUMN user_id TYPE bigint;
ALTER TABLE followers ALTER COLUMN user_id TYPE bigint;
ALTER TABLE followers ALTER COLUMN follower_id TYPE bigint;
ALTER TABLE up_comments ALTER COLUMN user_id TYPE bigint;
ALTER TABLE user_settings ALTER COLUMN user_id TYPE bigint;
ALTER TABLE android_oauth_tokens ALTER COLUMN user_id TYPE bigint;

UPDATE meta_info
  SET version = 14;

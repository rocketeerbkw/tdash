SELECT version from meta_info;
\prompt "Did you see 14 above? If no, press Ctrl+c now!" correctVersion

DROP FUNCTION set_old_on_top(INTEGER, BOOLEAN);

CREATE OR REPLACE LANGUAGE plpgsql;

CREATE FUNCTION set_old_on_top(user_id_a BIGINT, setting BOOLEAN) RETURNS VOID AS
$$
  BEGIN
    LOOP
      -- first try to update the key
      UPDATE user_settings SET old_on_top = setting WHERE user_id = user_id_a;

      IF found THEN
        RETURN;
      END IF;

      -- not there, so try to insert the key
      -- if someone else inserts the same key concurrently,
      -- we could get a unique-key failure
      BEGIN
        INSERT INTO user_settings(user_id,old_on_top) VALUES (user_id_a, setting);
        RETURN;
      EXCEPTION WHEN unique_violation THEN
        -- do nothing, and loop to try the UPDATE again
      END;
    END LOOP;
  END;
$$
LANGUAGE plpgsql;

UPDATE meta_info
  SET version = 15;

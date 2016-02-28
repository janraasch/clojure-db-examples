-- name: add-user!
-- add user
INSERT INTO users
(id, pass)
VALUES (:id, :pass)

-- name: select-user
-- select user by id
SELECT *
FROM users
WHERE id = :id

-- name: select-date
-- select current date
SELECT now()::date;
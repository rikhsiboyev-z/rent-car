create table "user"
(
    id   uuid default gen_random_uuid(),
    name varchar unique ,
    password varchar
);

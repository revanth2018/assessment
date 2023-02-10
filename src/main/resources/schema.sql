create table "transaction"
(
    "id" integer auto_increment primary key ,
    "customer_id" varchar(100) not null ,
    "amount" float DEFAULT NULL,
    "transaction_date" date DEFAULT NULL,
    "created_at" timestamp,
    "updated_at" timestamp
);

create table "user"
(
    "id" integer auto_increment primary key ,
    "customer_id" varchar(100) not null unique ,
    "first_name" varchar(100) not null ,
    "last_name" varchar(100) not null,
    "created_at" timestamp,
    "updated_at" timestamp
);
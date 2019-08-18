alter table circles
    add support_mail varchar(128) not null default '';

alter table circles
    add home_page varchar(128) not null default '';

# アカウントに対してサークルは一つだけにしたいのでユニーク制約を貼るために外部キー制約を一度外して付け直し
alter table circles
    drop foreign key circles_account_id_fk;
create unique index circles_account_id_uindex on circles (account_id);
alter table circles
    add constraint circles_accounts_id_fk foreign key (account_id) references accounts (id);


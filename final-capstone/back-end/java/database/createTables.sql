Begin transaction;

drop table if exists landmarks;

create table destinations
(
  destination_id serial       NOT NULL,
  name           varchar(50)  NOT NULL,
  description    text         NOT NULL,
  street_address varchar(100) NOT NULL,
  city           varchar(10)  DEFAULT 'Cleveland',
  state          char(2)      DEFAULT 'OH',
  zipcode        varchar(10)  NOT NULL,
  latitude       decimal(8,6) NOT NULL,
  longitude      decimal(8,6) NOT NULL,
  website        varchar(100) NOT NULL,
  constraint pk_destinations primary key (destination_id)
);

create table day_of_week
(
  
);
  
rollback;


  
  
  
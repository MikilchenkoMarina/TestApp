CREATE TABLE public.user
(
    id serial NOT NULL PRIMARY KEY,
    first_name varchar(15),
    last_name varchar(15),
    userName varchar(15) UNIQUE,
    password varchar(15)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

commit;

ALTER TABLE public.user
    OWNER to postgres;
    
    	CREATE TABLE public.reminder (
        id serial NOT NULL,
        text varchar(200),
        imageLink varchar(200),
        user_id integer references  public.user(id) ON DELETE CASCADE ON UPDATE CASCADE
)WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

commit;

ALTER TABLE public.reminder
    OWNER to postgres;

select * from public.user;
    
    
    ALTER TABLE public.user ADD CONSTRAINT  UNIQUE  userName ;
    
    CREATE UNIQUE INDEX must_be_different ON public.user (public.user.userName);
    
    
    INSERT INTO public.user (FIRST_NAME,LAST_NAME,USERNAME,PASSWORD) VALUES('Marina','Mikilchenko','mikimar','pass');
      INSERT INTO public.user (FIRST_NAME,LAST_NAME,USERNAME,PASSWORD) VALUES('Marina','Mikilchenko','mikimar333','mikimar333');
           INSERT INTO public.user (FIRST_NAME,LAST_NAME,USERNAME,PASSWORD) VALUES('Marina','Mikilchenko','mikmar333','mikmar333');
    select * from public.user ;
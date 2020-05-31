--
-- PostgreSQL database dump
--

-- Dumped from database version 12.2
-- Dumped by pg_dump version 12.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: users; Type: SCHEMA; Schema: -; Owner: postgres
--

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: pictures; Type: TABLE; Schema: users; Owner: postgres
--

CREATE TABLE users.picture (
    id integer NOT NULL,
    url text NOT NULL,
    "userId" integer
);


--ALTER TABLE users.pictures OWNER TO postgres;

--
-- Name: pictures_id_seq; Type: SEQUENCE; Schema: users; Owner: postgres
--

CREATE SEQUENCE users.picture_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--ALTER TABLE users.pictures_id_seq OWNER TO postgres;

--
-- Name: pictures_id_seq; Type: SEQUENCE OWNED BY; Schema: users; Owner: postgres
--

ALTER SEQUENCE users.picture_id_seq OWNED BY users.picture.id;


--
-- Name: users; Type: TABLE; Schema: users; Owner: postgres
--

CREATE TABLE users.user (
    "userId" integer NOT NULL,
    description text,
    breed text,
    age integer NOT NULL,
    name text NOT NULL,
    sex text NOT NULL
);


--ALTER TABLE users.users OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: users; Owner: postgres
--

CREATE SEQUENCE users.user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--ALTER TABLE users.users_id_seq OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: users; Owner: postgres
--

ALTER SEQUENCE users.user_id_seq OWNED BY users.user."userId";


--
-- Name: pictures id; Type: DEFAULT; Schema: users; Owner: postgres
--

ALTER TABLE ONLY users.picture ALTER COLUMN id SET DEFAULT nextval('users.picture_id_seq'::regclass);


--
-- Name: users userId; Type: DEFAULT; Schema: users; Owner: postgres
--

ALTER TABLE ONLY users.user ALTER COLUMN "userId" SET DEFAULT nextval('users.user_id_seq'::regclass);





--
-- Name: pictures_id_seq; Type: SEQUENCE SET; Schema: users; Owner: postgres
--

SELECT pg_catalog.setval('users.picture_id_seq', 122, true);


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: users; Owner: postgres
--

SELECT pg_catalog.setval('users.user_id_seq', 16, true);


--
-- Name: pictures pictures_pkey; Type: CONSTRAINT; Schema: users; Owner: postgres
--

ALTER TABLE ONLY users.picture
    ADD CONSTRAINT picture_pkey PRIMARY KEY (id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: users; Owner: postgres
--

ALTER TABLE ONLY users.user
    ADD CONSTRAINT user_pkey PRIMARY KEY ("userId");


--
-- Name: pictures pictures_user_id_fkey; Type: FK CONSTRAINT; Schema: users; Owner: postgres
--

ALTER TABLE ONLY users.picture
    ADD CONSTRAINT picture_user_id_fkey FOREIGN KEY ("userId") REFERENCES users.user("userId");


--
-- PostgreSQL database dump complete
--


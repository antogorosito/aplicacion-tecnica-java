--
-- PostgreSQL database dump
--

-- Dumped from database version 12.0
-- Dumped by pg_dump version 12.0

-- Started on 2019-11-12 09:55:39

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 203 (class 1259 OID 16576)
-- Name: alumno; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.alumno (
    identificador integer NOT NULL,
    idpersona integer,
    legajo integer NOT NULL
);


ALTER TABLE public.alumno OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16588)
-- Name: carrera; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.carrera (
    identificador integer NOT NULL,
    nombre character varying(40) NOT NULL,
    descripcion character varying(250),
    fechadesde date NOT NULL,
    fechahasta date
);


ALTER TABLE public.carrera OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 16593)
-- Name: curso; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.curso (
    identificador integer NOT NULL,
    idcarrera integer,
    nombre character varying(40) NOT NULL,
    descripcion character varying(250),
    cupomaximo smallint NOT NULL,
    anio smallint NOT NULL,
    iddocente integer
);


ALTER TABLE public.curso OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 16682)
-- Name: docente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.docente (
    identificador integer NOT NULL,
    cargo character varying,
    idpersona integer
);


ALTER TABLE public.docente OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 16603)
-- Name: inscripciones_carrera; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.inscripciones_carrera (
    idalumno integer NOT NULL,
    idcarrera integer NOT NULL,
    fechainscripcion date NOT NULL
);


ALTER TABLE public.inscripciones_carrera OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 16665)
-- Name: inscripciones_curso; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.inscripciones_curso (
    idalumno integer NOT NULL,
    idcurso integer NOT NULL,
    fechainscripcion date NOT NULL,
    nota integer,
    estado character varying(20)
);


ALTER TABLE public.inscripciones_curso OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16571)
-- Name: persona; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.persona (
    identificador integer NOT NULL,
    tipodoc character(5) NOT NULL,
    documento bigint NOT NULL,
    nombre character varying(40) NOT NULL,
    apellido character varying(40) NOT NULL,
    fechanac date,
    direccion character varying(80)
);


ALTER TABLE public.persona OWNER TO postgres;

--
-- TOC entry 2857 (class 0 OID 16576)
-- Dependencies: 203
-- Data for Name: alumno; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.alumno (identificador, idpersona, legajo) FROM stdin;
1	3	98734
2	4	9213
4	5	36299
5	2	11009
6	6	39772
7	8	345
3	1	35839
\.


--
-- TOC entry 2858 (class 0 OID 16588)
-- Dependencies: 204
-- Data for Name: carrera; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.carrera (identificador, nombre, descripcion, fechadesde, fechahasta) FROM stdin;
1	Ingenieria en sistema de informaciÃ³n	Carrera a fines a programaciÃ³n y desarrollo de software en general	1960-01-01	\N
2	Ingenieria civil	Carrera a fines a construcciÃ³n, planificaciÃ³n y desarrollo de obras de desarrollo urbano	1980-01-01	\N
\.


--
-- TOC entry 2859 (class 0 OID 16593)
-- Dependencies: 205
-- Data for Name: curso; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.curso (identificador, idcarrera, nombre, descripcion, cupomaximo, anio, iddocente) FROM stdin;
4	1	Base de datos-SQL	Curso sobre tipos de base de datos y consultas sql	10	2018	1
5	2	Fisica bÃ¡sica	Curso sobre fundamentos base de fÃ­sica	5	2018	1
6	2	Dibujo	Curso sobre dibujo de planos	10	2018	1
2	1	DiseÃ±o de sistemas	Curso sobre diseÃ±o de componentes de sistemas de software	10	2018	1
3	1	Java	Curso sobre el lenguaje de programaciÃ³n JAVA	10	2018	1
1	1	AnÃ¡lisis matemÃ¡tico	Curso sobre el desarrollo avanzado de matemÃ¡ticas	5	2018	1
\.


--
-- TOC entry 2862 (class 0 OID 16682)
-- Dependencies: 208
-- Data for Name: docente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.docente (identificador, cargo, idpersona) FROM stdin;
1	Titular	7
\.


--
-- TOC entry 2860 (class 0 OID 16603)
-- Dependencies: 206
-- Data for Name: inscripciones_carrera; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.inscripciones_carrera (idalumno, idcarrera, fechainscripcion) FROM stdin;
1	1	2000-01-01
2	1	2003-01-01
3	1	2004-01-01
4	1	2001-01-01
5	2	2000-01-01
4	2	2000-01-01
\.


--
-- TOC entry 2861 (class 0 OID 16665)
-- Dependencies: 207
-- Data for Name: inscripciones_curso; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.inscripciones_curso (idalumno, idcurso, fechainscripcion, nota, estado) FROM stdin;
2	1	2004-01-01	\N	\N
2	4	2004-01-01	\N	\N
3	1	2010-01-01	\N	\N
3	3	2010-01-01	\N	\N
4	1	2010-01-01	\N	\N
4	3	2010-01-01	\N	\N
5	3	2010-01-01	\N	\N
4	3	2010-01-01	\N	\N
5	4	2011-01-01	\N	\N
4	4	2011-01-01	\N	\N
2	5	2011-01-01	\N	\N
2	6	2011-01-01	\N	\N
2	3	2019-11-11	\N	\N
1	2	2006-01-01	9	aprobado
1	3	2002-01-01	8	aprobado
1	1	2019-01-01	\N	\N
2	2	2019-11-12	\N	\N
\.


--
-- TOC entry 2856 (class 0 OID 16571)
-- Dependencies: 202
-- Data for Name: persona; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.persona (identificador, tipodoc, documento, nombre, apellido, fechanac, direccion) FROM stdin;
2	DNI  	31000123	Patricia	Brumatti	1985-01-13	\N
3	DNI  	20945422	Diego	Menendez	1982-04-10	\N
4	DNI  	30999281	Franzo	Perez	1986-02-05	\N
5	DNI  	24112872	Leandro	Garcia	1988-01-03	\N
6	dni  	37607895	Antonella	Gorosito	1993-06-21	\N
7	dni  	14444308	sergio	gorosito	1961-04-13	leiva 5162
8	DNI  	38987456	sabrina	velazquez	1992-08-05	San martin 456
1	DNI  	31565839	Florencia	Maneiro	1985-06-28	null
10	DNI  	14555000	Sergio	Gorosito	1961-04-13	 San Martin 456
\.


--
-- TOC entry 2713 (class 2606 OID 16582)
-- Name: alumno alumno_idpersona_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.alumno
    ADD CONSTRAINT alumno_idpersona_key UNIQUE (idpersona);


--
-- TOC entry 2715 (class 2606 OID 16580)
-- Name: alumno alumno_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.alumno
    ADD CONSTRAINT alumno_pkey PRIMARY KEY (identificador);


--
-- TOC entry 2717 (class 2606 OID 16592)
-- Name: carrera carrera_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.carrera
    ADD CONSTRAINT carrera_pkey PRIMARY KEY (identificador);


--
-- TOC entry 2719 (class 2606 OID 16597)
-- Name: curso curso_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.curso
    ADD CONSTRAINT curso_pkey PRIMARY KEY (identificador);


--
-- TOC entry 2721 (class 2606 OID 16694)
-- Name: docente docente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.docente
    ADD CONSTRAINT docente_pkey PRIMARY KEY (identificador);


--
-- TOC entry 2711 (class 2606 OID 16575)
-- Name: persona persona_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_pkey PRIMARY KEY (identificador);


--
-- TOC entry 2722 (class 2606 OID 16583)
-- Name: alumno alumno_idpersona_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.alumno
    ADD CONSTRAINT alumno_idpersona_fkey FOREIGN KEY (idpersona) REFERENCES public.persona(identificador);


--
-- TOC entry 2723 (class 2606 OID 16598)
-- Name: curso curso_idcarrera_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.curso
    ADD CONSTRAINT curso_idcarrera_fkey FOREIGN KEY (idcarrera) REFERENCES public.carrera(identificador);


--
-- TOC entry 2724 (class 2606 OID 16695)
-- Name: curso curso_iddocente_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.curso
    ADD CONSTRAINT curso_iddocente_fkey FOREIGN KEY (iddocente) REFERENCES public.docente(identificador) NOT VALID;


--
-- TOC entry 2729 (class 2606 OID 16688)
-- Name: docente id_docente_fkpersona; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.docente
    ADD CONSTRAINT id_docente_fkpersona FOREIGN KEY (idpersona) REFERENCES public.persona(identificador);


--
-- TOC entry 2725 (class 2606 OID 16606)
-- Name: inscripciones_carrera inscripciones_carrera_idalumno_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.inscripciones_carrera
    ADD CONSTRAINT inscripciones_carrera_idalumno_fkey FOREIGN KEY (idalumno) REFERENCES public.alumno(identificador);


--
-- TOC entry 2726 (class 2606 OID 16611)
-- Name: inscripciones_carrera inscripciones_carrera_idcarrera_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.inscripciones_carrera
    ADD CONSTRAINT inscripciones_carrera_idcarrera_fkey FOREIGN KEY (idcarrera) REFERENCES public.carrera(identificador);


--
-- TOC entry 2727 (class 2606 OID 16668)
-- Name: inscripciones_curso inscripciones_curso_idalumno_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.inscripciones_curso
    ADD CONSTRAINT inscripciones_curso_idalumno_fkey FOREIGN KEY (idalumno) REFERENCES public.alumno(identificador);


--
-- TOC entry 2728 (class 2606 OID 16673)
-- Name: inscripciones_curso inscripciones_curso_idcurso_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.inscripciones_curso
    ADD CONSTRAINT inscripciones_curso_idcurso_fkey FOREIGN KEY (idcurso) REFERENCES public.curso(identificador);


-- Completed on 2019-11-12 09:55:39

--
-- PostgreSQL database dump complete
--


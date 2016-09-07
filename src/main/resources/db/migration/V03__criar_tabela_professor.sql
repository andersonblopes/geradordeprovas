CREATE TABLE public.professor (
  pkprofessor SERIAL,
  cpf TEXT NOT NULL,
  professor TEXT NOT NULL,
  fkdisciplina INTEGER,
  CONSTRAINT pkprofessor PRIMARY KEY(pkprofessor),
  CONSTRAINT fkdisciplina FOREIGN KEY (fkdisciplina)
    REFERENCES public.disciplina(pkdisciplina)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE
);
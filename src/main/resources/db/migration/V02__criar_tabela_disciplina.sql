CREATE TABLE public.disciplina (
  pkdisciplina SERIAL,
  cargahoraria INTEGER,
  codmec TEXT NOT NULL,
  disciplina TEXT NOT NULL,
  CONSTRAINT pkdisciplina PRIMARY KEY(pkdisciplina)
);
CREATE TABLE public.tipo_turma (
  pktipoturma SERIAL,
  codtipoturma TEXT NOT NULL,
  tipoturma TEXT NOT NULL,
  CONSTRAINT pktipoturma PRIMARY KEY(pktipoturma),
  CONSTRAINT uq_tipoturma UNIQUE(tipoturma),
  CONSTRAINT uq_codtipoturma UNIQUE(codtipoturma)
);
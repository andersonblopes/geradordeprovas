CREATE TABLE public.turma (
  pkturma SERIAL,
  codmec TEXT,
  horafinal TEXT NOT NULL,
  horainicial TEXT NOT NULL,
  maiseducacao BOOLEAN NOT NULL,
  turma TEXT NOT NULL,
  fktipoturma INTEGER,
  CONSTRAINT pkturma PRIMARY KEY(pkturma),
  CONSTRAINT fktipoturma FOREIGN KEY (fktipoturma)
    REFERENCES public.tipo_turma(pktipoturma)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE
);
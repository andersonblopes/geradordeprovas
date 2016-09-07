CREATE TABLE public.aluno (
  id serial,
  celular TEXT,
  cpf TEXT,
  datanascimento DATE NOT NULL,
  matricula TEXT NOT NULL,
  nome TEXT NOT NULL,
  responsavel TEXT NOT NULL,
  telefoneresponsavel TEXT NOT NULL,
  sexo CHAR NOT NULL,
  fkturma INTEGER,
  CONSTRAINT id PRIMARY KEY(id),
  CONSTRAINT uq_cpf UNIQUE(cpf),
  CONSTRAINT fkturma FOREIGN KEY (fkturma)
    REFERENCES public.turma(pkturma)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
    NOT DEFERRABLE
);
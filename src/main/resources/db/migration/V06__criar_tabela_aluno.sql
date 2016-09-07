CREATE TABLE public.aluno (
  id serial,
  celular TEXT,
  cpf TEXT,
  datanascimento DATE NOT NULL,
  matricula TEXT NOT NULL,
  nome TEXT NOT NULL,
  responsavel TEXT NOT NULL,
  telefoneresponsavel TEXT NOT NULL,
  fksexo INTEGER NOT NULL,
  fkturma INTEGER,
  CONSTRAINT id PRIMARY KEY(id),
  CONSTRAINT uq_cpf UNIQUE(cpf),
  CONSTRAINT fkturma FOREIGN KEY (fkturma)
    REFERENCES public.turma(pkturma)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE,
  CONSTRAINT fksexo FOREIGN KEY (fksexo)
    REFERENCES public.sexo(pksexo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE
);
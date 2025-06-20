package br.universidade.manifestarintencao.config;

import br.universidade.manifestarintencao.entity.*;
import br.universidade.manifestarintencao.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
//Classe para popular o banco ao subir a aplicacao
@Component
public class DataInitializer implements CommandLineRunner {

    private final DisciplinaRepository disciplinaRepository;
    private final NucleoRepository nucleoRepository;
    private final DocenteRepository docenteRepository;
    private final TurmaRepository turmaRepository;
    private final ManifestacaoInteresseRepository manifestacaoInteresseRepository;

    public DataInitializer(DisciplinaRepository disciplinaRepository,
                           NucleoRepository nucleoRepository,
                           DocenteRepository docenteRepository,
                           TurmaRepository turmaRepository,
                           ManifestacaoInteresseRepository manifestacaoInteresseRepository) {
        this.disciplinaRepository = disciplinaRepository;
        this.nucleoRepository = nucleoRepository;
        this.docenteRepository = docenteRepository;
        this.turmaRepository = turmaRepository;
        this.manifestacaoInteresseRepository = manifestacaoInteresseRepository;
    }

    @Override
    public void run(String... args) {
        // Criar núcleos
        Nucleo exatas = criarNucleo("Núcleo de Exatas");
        Nucleo humanas = criarNucleo("Núcleo de Humanas");
        Nucleo biologicas = criarNucleo("Núcleo de Biológicas");

        // Criar disciplinas
        Disciplina matematica = criarDisciplina("Matemática Básica", 60, exatas);
        Disciplina fisica = criarDisciplina("Física I", 80, exatas);
        Disciplina historia = criarDisciplina("História Geral", 60, humanas);
        Disciplina biologia = criarDisciplina("Biologia Celular", 70, biologicas);

        // Criar docentes
        Docente carlos = criarDocente("Carlos Silva", "123456");
        Docente maria = criarDocente("Maria Souza", "654321");
        Docente joao = criarDocente("João Pereira", "112233");

        // Criar turmas
        Turma turmaMat = criarTurma(2024, 1, matematica);
        Turma turmaFis = criarTurma(2024, 1, fisica);
        Turma turmaHis = criarTurma(2024, 1, historia);
        Turma turmaBio = criarTurma(2024, 1, biologia);

        // Criar manifestações de interesse
        criarManifestacao(carlos, turmaMat, "Manhã", StatusManifestacao.ACEITA);
        criarManifestacao(carlos, turmaFis, "Noite", StatusManifestacao.PENDENTE);
        criarManifestacao(maria, turmaHis, "Tarde", StatusManifestacao.ACEITA);
        criarManifestacao(joao, turmaBio, "Manhã", StatusManifestacao.PENDENTE);

        System.out.println("✅ Dados iniciais salvos no banco");
    }

    private Nucleo criarNucleo(String nome) {
        Nucleo nucleo = new Nucleo();
        nucleo.setNome(nome);
        return nucleoRepository.save(nucleo);
    }

    private Disciplina criarDisciplina(String nome, int cargaHoraria, Nucleo nucleo) {
        Disciplina disciplina = new Disciplina();
        disciplina.setNome(nome);
        disciplina.setCargaHoraria(cargaHoraria);
        disciplina.setNucleo(nucleo);
        return disciplinaRepository.save(disciplina);
    }

    private Docente criarDocente(String nome, String siape) {
        Docente docente = new Docente();
        docente.setNome(nome);
        docente.setSiape(siape);
        return docenteRepository.save(docente);
    }

    private Turma criarTurma(int ano, int semestre, Disciplina disciplina) {
        Turma turma = new Turma();
        turma.setAno(ano);
        turma.setSemestre(semestre);
        turma.setDisciplina(disciplina);
        return turmaRepository.save(turma);
    }

    private void criarManifestacao(Docente docente, Turma turma, String turno, StatusManifestacao status) {
        ManifestacaoInteresse mi = new ManifestacaoInteresse();
        mi.setDocente(docente);
        mi.setTurma(turma);
        mi.setTurnoPreferido(turno);
        mi.setStatus(status);
        manifestacaoInteresseRepository.save(mi);
    }
}

package view;

public class JanelaFacade {
	protected JanelaCadastroAluno frameCadastroAluno;
	protected JanelaBuscaAluno frameBuscaAluno;

	protected JanelaCadastrarTreino frameCadastrarTreino;
	protected JanelaCadastrarExercicio frameCadastrarExercicio;
	protected JanelaBuscaExercicio frameBuscaExercicio;

	protected JanelaBuscaProfessor frameBuscaProfessor;
	protected JanelaCadastroProfessor frameCadastroProfessor;
	

	public JanelaFacade() {

		frameCadastroAluno = new JanelaCadastroAluno();
		frameBuscaAluno = new JanelaBuscaAluno();

		frameCadastroProfessor = new JanelaCadastroProfessor();
		frameBuscaProfessor = new JanelaBuscaProfessor();

		frameCadastrarTreino = new JanelaCadastrarTreino();
		frameCadastrarExercicio = new JanelaCadastrarExercicio();
		frameBuscaExercicio = new JanelaBuscaExercicio();
	
	}
}

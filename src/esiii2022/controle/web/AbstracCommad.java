package esiii2022.controle.web;

import esiii2022.controle.IFachada;
import esiii2022.controle.impl.Fachada;

public abstract class AbstracCommad implements ICommand {

	protected IFachada fachada = new Fachada();
}

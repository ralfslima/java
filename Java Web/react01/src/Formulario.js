import React from 'react';

class Formulario extends React.Component{

    constructor(props){
        super(props);

        this.state = {
            nome : ''
        }
    }

    digitarNome = (elemento) => {
        this.setState({nome : elemento.target.value});
    }

    botao = () => {
        alert('Boa noite ' + this.state.nome);
    }

    render(){
        return(
            <form>
                <input type='text' placeholder='Nome' onChange={this.digitarNome} />
                <button onClick={this.botao}>Clique aqui</button>
                {/* <p>{this.state.nome}</p> */}
            </form>
        );
    }

}

export default Formulario;
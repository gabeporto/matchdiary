import { InputHTMLAttributes } from "react"
import styled from "styled-components"

const InputDiv = styled.div`
    width: 92%;
`

const LabelStyled = styled.p`
    font-family: 'Futura';
    color: #000;
    text-transform: uppercase;
    font-weight: lighter;
`

const InputStyled = styled.input`
    font-family: 'Futura';
    padding: 10px;
    width: 100px;
    height: 100%;
    border: none;
    border-radius: 10px;
    background-color: #EFEFEE;
    color: #000;
    outline: none;
    font-size: 50px;
    margin-top: 12px;
    text-align: center;
    transition: 0.3s ease;

    &:hover {
        background-color: #E3E3E3;
    }
`

interface InputProps extends InputHTMLAttributes<HTMLInputElement> {
}


export default function InputScore(props : InputProps) {
    return (
        <InputDiv>
            <LabelStyled />
            <InputStyled {...props} />
        </InputDiv>
    )
}
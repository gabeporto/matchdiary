import { SelectHTMLAttributes } from "react";
import styled from "styled-components";

interface InputSelectProps extends SelectHTMLAttributes<HTMLSelectElement> {
    label: string;
    options: {label: string; value: number}[];
}

const SelectContainer = styled.div`
    display: flex;
    flex-direction: column;
    margin-bottom: 16px;
`

const LabelStyled = styled.p`
    font-family: 'Futura';
    color: #000;
    text-transform: uppercase;
    font-weight: lighter;
    margin-bottom: 8px;

`

const SelectStyled = styled.select`
    font-family: 'Futura';
    padding: 10px;
    border: none;
    border-radius: 10px;
    background-color: #EFEFEE;
    color: #000;
    outline: none;
    font-size: 16px;
    transition: 0.3s ease;

    &:hover {
        background-color: #E3E3E3;
    }
`

const InputSelect: React.FC<InputSelectProps> = ({ label, options, ...props }) => (
    <SelectContainer>
      <LabelStyled>{label}</LabelStyled>
      <SelectStyled {...props}>
        <option value="0">
          Selecione um time
        </option>
        {options.map((option) => (
          <option key={option.value} value={option.value}>
            {option.label}
          </option>
        ))}
      </SelectStyled>
    </SelectContainer>
  );
  
  export default InputSelect;
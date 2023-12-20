import styled from "styled-components"

const CardContainer = styled.div`
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    height: 380px;
    width: 830px;
    background-color: #F3F2F2;
    border-radius: 12px;

    @media (max-width: 1614px) {
        width: 650px; 
    }
    
    @media (max-width: 1500px) {
        width: 600px;
    }

    @media (max-width: 1391px) {
        width: 500px;
    }

    @media (max-width: 1161px) {
        width: 450px;
    }

    @media (max-width: 1046px) {
        width: 100%;
    }
`

const ValueDiv = styled.div`
    font-family: 'Barlow', sans-serif;
    font-weight: bold;
    font-size: 96px;
    padding: 10px;
`

const DescriptionDiv = styled.div`
    display: flex;
    font-family: 'Barlow', sans-serif;
    font-size: 16px;
    text-transform: uppercase;
    padding: 10px;

    @media (max-width: 400px) {
        font-size: 13px;
    }

    @media (max-width: 288px) {
        font-size: 10px;
    }
`

const TeamPhotoImg = styled.img`
    width: 120px;
    padding: 10px;
`

const TeamNameDiv = styled.div`
    font-family: 'Barlow', sans-serif;
    font-weight: bold;
    font-size: 20px;
    text-transform: uppercase;
    margin-top: 20px;
    margin-bottom: 20px;
`

interface CardProps {
    value?: number | string,
    teamUrl?: string,
    teamName?: string,
    description: string
}

export default function BiggerCard(props : CardProps) {
    return (
        <CardContainer>
            {props.value && <ValueDiv>{props.value}</ValueDiv>}
            {props.teamUrl && <TeamPhotoImg src={props.teamUrl}></TeamPhotoImg>}
            {props.teamName && <TeamNameDiv>{props.teamName}</TeamNameDiv>}
            <DescriptionDiv>{props.description}</DescriptionDiv>
        </CardContainer>
    )
}
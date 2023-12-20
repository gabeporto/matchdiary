import { useEffect, useState } from "react";
import Container from "../../components/Container";
import Navbar from "../../components/Navbar";
import Title from "../../components/Title";
import { MatchData } from "../../interfaces/MatchData";
import api from "../../services/api";
import MatchTable from "../../components/MatchTable";

export default function MatchListPage() {

    const [data, setData] = useState<MatchData[]>([]);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await api.getMatchData();
                setData(response.data);
            } catch (error) {
                console.log('Erro ao buscar dados dos times:', error);
            }
        }
        fetchData();
    }, []);

    return (
        <>
            <Navbar />

            <Container>
                <Title title="Partidas registradas"/>

                <MatchTable matches={data} /> 
            </Container>
        </>
    )
}
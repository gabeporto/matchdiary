import axios, { AxiosResponse } from "axios";
import { ReportsData } from "../interfaces/ReportsData";
import { TeamData } from "../interfaces/TeamData";
import { MatchData } from "../interfaces/MatchData";
import { MatchRequestData } from "../interfaces/MatchRequestData";

interface Api {
    getReportsData: () => Promise<AxiosResponse<ReportsData>>;

    getTeamData: () => Promise<AxiosResponse<TeamData[]>>;
    getTeamDataById: (id: number) => Promise<AxiosResponse<TeamData>>;
    addTeam: (teamData : TeamData) => Promise<AxiosResponse<any>>;
    editTeam: (teamData : TeamData) => Promise<AxiosResponse<any>>;
    deleteTeam: (id: number) => Promise<AxiosResponse<any>>;

    getMatchData: () => Promise<AxiosResponse<MatchData[]>>;
    getMatchDataById: (id: number) => Promise<AxiosResponse<MatchData>>;
    addMatch: (matchData : MatchRequestData) => Promise<AxiosResponse<any>>;
    editMatch: (matchData : MatchRequestData) => Promise<AxiosResponse<any>>;
    deleteMatch: (id: number) => Promise<AxiosResponse<any>>;
}


const instance = axios.create({
    baseURL: 'http://localhost:8080/api',
    headers: {
        'Access-Control-Allow-Origin': 'http://localhost:3000',
    },
});

const api: Api = {
    getReportsData: () => instance.get('/reports'),

    getTeamData: () => instance.get('/team/all'),
    getTeamDataById: (id: number) => instance.get(`/team/${id}`),
    addTeam: (teamData : TeamData) => instance.post('/team', teamData),
    editTeam: (teamData : TeamData) => instance.put('/team', teamData),
    deleteTeam: (id: number) => instance.delete(`/team/${id}`),

    getMatchData: () => instance.get('/match/all'),
    getMatchDataById: (id: number) => instance.get(`/match/${id}`),
    addMatch: (matchData : MatchRequestData) => instance.post('/match', matchData),
    editMatch: (matchData : MatchRequestData) =>instance.put('/match', matchData),
    deleteMatch: (id: number) => instance.delete(`/match/${id}`),
};

export default api;
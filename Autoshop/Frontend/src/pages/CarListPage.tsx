import { useEffect, useState } from "react";
import Container from "@mui/material/Container";
import TextField from "@mui/material/TextField";
import InputAdornment from "@mui/material/InputAdornment";
import SearchIcon from "@mui/icons-material/Search";
import client from "../api/client";
import type { Car } from "../types/Car";
import CarCard from "../components/CarCard";
import Grid from '@mui/material/Grid';

export default function CarListPage() {
    const [cars, setCars] = useState<Car[]>([]);
    const [q, setQ] = useState("");

    useEffect(() => {
        client
            .get<Car[]>("/cars", { params: q ? { q } : undefined })
            .then((res) => setCars(res.data))
            .catch(console.error);
    }, [q]);

    return (
        <Container sx={{ py: 3 }}>
            <TextField
                placeholder="Suche (Marke/Modell)"
                fullWidth
                sx={{ mb: 2 }}
                value={q}
                onChange={(e) => setQ(e.target.value)}
                InputProps={{
                    startAdornment: (
                        <InputAdornment position="start">
                            <SearchIcon />
                        </InputAdornment>
                    ),
                }}
            />
            <Grid container spacing={2}>
                {cars.map((car) => (
                    <Grid key={car.id} >
                        <CarCard car={car} />
                    </Grid>
                ))}
            </Grid>
        </Container>
    );
}

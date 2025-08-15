import { useEffect, useState } from "react";
import { useParams, Link as RouterLink } from "react-router-dom";
import Box from "@mui/material/Box";
import Button from "@mui/material/Button";
import Chip from "@mui/material/Chip";
import Container from "@mui/material/Container";
import Divider from "@mui/material/Divider";
import Grid from "@mui/material/Grid";
import Paper from "@mui/material/Paper";
import Stack from "@mui/material/Stack";
import Typography from "@mui/material/Typography";
import client from "../api/client";
import type { Car } from "../types/Car";

const chf = new Intl.NumberFormat("de-CH", {
    style: "currency",
    currency: "CHF",
    maximumFractionDigits: 0,
});

export default function CarDetailPage() {
    const { id } = useParams<{ id: string }>();
    const [car, setCar] = useState<Car | null>(null);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {
        client
            .get<Car>(`/cars/${id}`)
            .then((res) => setCar(res.data))
            .catch((err) => setError(err.message));
    }, [id]);

    if (error) {
        return (
            <Container sx={{ py: 4 }}>
                <Typography color="error">Fehler: {error}</Typography>
                <Button variant="outlined" component={RouterLink} to="/">
                    Zur Übersicht
                </Button>
            </Container>
        );
    }

    if (!car) {
        return (
            <Container sx={{ py: 4 }}>
                <Typography>Wird geladen…</Typography>
            </Container>
        );
    }

    return (
        <Container sx={{ py: 4 }}>
            <Stack
                direction="row"
                justifyContent="space-between"
                alignItems="center"
                sx={{ mb: 2 }}
            >
                <Typography variant="h4">
                    {car.make} {car.model}
                </Typography>
                <Button variant="outlined" component={RouterLink} to="/">
                    ← Zurück
                </Button>
            </Stack>

            <Paper sx={{ p: 3 }}>
                <Grid container spacing={3}>
                        <Box
                            component="img"
                            src={
                                car.imageUrl ||
                                "https://images.unsplash.com/photo-1549921296-3a6b3f02faee?w=1200&auto=format&fit=crop"
                            }
                            alt={`${car.make} ${car.model}`}
                            sx={{
                                width: "100%",
                                borderRadius: 2,
                                objectFit: "cover",
                                aspectRatio: "16/9",
                            }}
                        />
                    </Grid>
                        <Stack spacing={2}>
                            <Typography variant="h5">{chf.format(car.price)}</Typography>
                            <Stack direction="row" spacing={1}>
                                <Chip label={`Jahrgang ${car.year}`} />
                                <Chip
                                    color={car.stock > 0 ? "success" : "default"}
                                    label={car.stock > 0 ? `${car.stock} auf Lager` : "Ausverkauft"}
                                />
                            </Stack>
                            <Divider />
                            <Typography variant="body1">ID: {car.id}</Typography>
                            {car.createdAt && (
                                <Typography variant="body2" color="text.secondary">
                                    Angelegt am: {new Date(car.createdAt).toLocaleString("de-CH")}
                                </Typography>
                            )}
                            <Divider />
                            <Typography variant="body1">
                                Beschreibung (Beispiel): Sportliche Limousine mit starker
                                Leistung und moderner Ausstattung.
                            </Typography>
                        </Stack>
            </Paper>
        </Container>
    );
}
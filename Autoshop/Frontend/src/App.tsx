import { AppBar, Toolbar, Typography, Container } from "@mui/material";
import { Routes, Route } from "react-router-dom";
import CarListPage from "./pages/CarListPage";
import CarDetailPage from "./pages/CarDetailPage";

export default function App() {
    return (
        <>
            <AppBar position="sticky" color="primary" elevation={2}>
                <Toolbar>
                    <Typography variant="h6">CARSHOP</Typography>
                </Toolbar>
            </AppBar>

            <Container maxWidth="lg" sx={{ py: 4 }}>
                <Routes>
                    <Route path="/" element={<CarListPage />} />
                    <Route path="/cars/:id" element={<CarDetailPage />} />
                </Routes>
            </Container>
        </>
    );
}
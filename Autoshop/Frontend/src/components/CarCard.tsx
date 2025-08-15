import { Card, CardContent, CardMedia, Typography, CardActionArea } from "@mui/material";
import { Link as RouterLink } from "react-router-dom";
import type { Car } from "../types/Car";

const chf = new Intl.NumberFormat("de-CH", { style: "currency", currency: "CHF", maximumFractionDigits: 0 });

export default function CarCard({ car }: { car: Car }) {
    const img =
        car.imageUrl ||
        "https://images.unsplash.com/photo-1549921296-3a6b3f02faee?w=1200&auto=format&fit=crop";

    return (
        <Card sx={{ width: 360, height: 440, display: "flex", flexDirection: "column" }}>
            <CardActionArea component={RouterLink} to={`/cars/${car.id}`} sx={{ height: "100%" }}>
                <CardMedia component="img" image={img} sx={{ height: 240, objectFit: "cover" }} />
                <CardContent>
                    <Typography variant="h5" noWrap>
                        {car.make} {car.model}
                    </Typography>
                    <Typography variant="body1">
                        {car.year} · {chf.format(car.price)}
                    </Typography>
                </CardContent>
            </CardActionArea>
        </Card>
    );
}
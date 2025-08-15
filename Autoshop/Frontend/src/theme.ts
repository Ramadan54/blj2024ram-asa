import { createTheme } from "@mui/material/styles";

const theme = createTheme({
    palette: {
        mode: "light",
        primary: { main: "#1E63D5" },
        background: { default: "#F6F7FB", paper: "#FFFFFF" },
    },
    shape: { borderRadius: 12 },
    typography: {
        fontFamily: "Inter, Roboto, Helvetica, Arial, sans-serif",
        h5: { fontWeight: 700, letterSpacing: 0.2 },
        h6: { fontWeight: 600 },
        body2: { color: "rgba(0,0,0,0.65)" },
    },
    components: {
        MuiCard: {
            styleOverrides: {
                root: { boxShadow: "0 6px 20px rgba(0,0,0,0.06)" },
            },
        },
        MuiAppBar: {
            styleOverrides: {
                root: { borderBottom: "1px solid #E5E7EB" },
            },
        },
    },
});

export default theme;

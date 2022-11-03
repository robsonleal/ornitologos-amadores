import CameraIcon from "@mui/icons-material/PhotoCamera";
import { AppBar, Toolbar, Typography } from "@mui/material";

let frutas: "banana" | "maça";

let positions:
  | "fixed"
  | "absolute"
  | "sticky"
  | "static"
  | "relative"
  | undefined;

interface TopbarProps {
  position?: typeof positions;
}

export function Topbar({ position }: TopbarProps) {
  return (
    <AppBar position={position}>
      <Toolbar>
        <CameraIcon sx={{ mr: 2 }} />
        <Typography variant="h6" color="inherit" noWrap>
          Album layout
        </Typography>
      </Toolbar>
    </AppBar>
  );
}

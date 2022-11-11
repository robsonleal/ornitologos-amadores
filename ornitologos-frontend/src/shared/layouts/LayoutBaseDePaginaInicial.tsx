import { Box, Paper, Typography, useTheme } from '@mui/material';

interface ILayoutBaseDePaginaInicialProps {
  children: React.ReactNode;
  titulo: string;
  subtitulo?: string;
  image?: {
    src: string;
    alt: string;
    width?: number;
  };
}

export const LayoutBaseDePaginaInicial: React.FC<
  ILayoutBaseDePaginaInicialProps
> = ({ children, titulo, subtitulo, image }) => {
  const theme = useTheme();

  return (
    <Box
      display='flex'
      alignItems='center'
      justifyContent='center'
      flexDirection='row'
      height={780}
      gap={15}
      component={Paper}
      elevation={3}
      sx={{
        margin: theme.spacing(6),
        borderRadius: theme.shape.borderRadius,
      }}
    >
      <Box maxWidth='sm'>
        <Typography
          variant='h2'
          component='h2'
          align='center'
          color={theme.palette.text.primary}
        >
          {titulo}
        </Typography>
        <Typography
          variant='h6'
          component='h4'
          align='center'
          color={theme.palette.text.secondary}
          paddingTop={1}
        >
          {subtitulo}
        </Typography>
        {children}
      </Box>
      <Box>{image ? <img src={image.src} alt={image.alt} /> : ''}</Box>
    </Box>
  );
};

import { Box, Typography, useTheme } from '@mui/material';
import { Container } from '@mui/system';

interface ILayoutBaseDePaginaProps {
  children: React.ReactNode;
  barraDeFerramentas?: React.ReactNode;
  titulo: string;
}

export const LayoutBaseDePagina: React.FC<ILayoutBaseDePaginaProps> = ({
  children,
  barraDeFerramentas: barraDeFerramentas,
  titulo,
}) => {
  const theme = useTheme();

  return (
    <Container>
      <Box
        height={theme.spacing(13)}
        display='flex'
        alignItems='center'
        gap={5}
        flexDirection='row'
      >
        <Typography variant='h4' component='h4'>
          {titulo}
        </Typography>

        {barraDeFerramentas && <Box flexGrow={1}>{barraDeFerramentas}</Box>}
      </Box>
      <Box flex={1} overflow='auto'>
        {children}
      </Box>
    </Container>
  );
};

import { Box } from '@mui/material';

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
  return (
    <Box height='100%' display='flex' flexDirection='column' gap={1}>
      <Box>{titulo}</Box>

      {barraDeFerramentas && <Box>{barraDeFerramentas}</Box>}

      <Box flex={1} overflow='auto'>
        {children}
      </Box>
    </Box>
  );
};

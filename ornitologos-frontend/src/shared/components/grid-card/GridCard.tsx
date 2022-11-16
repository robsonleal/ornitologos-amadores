import {
  Box,
  Card,
  CardContent,
  CardMedia,
  Grid,
  Typography,
} from '@mui/material';
import { Habitat } from '..';
import { IListagemAve } from '../../models';

interface GridCardProps {
  cards: IListagemAve[];
  totalCount: number;
}

export const GridCard: React.FC<GridCardProps> = ({ cards, totalCount }) => {
  return (
    <Grid
      container
      spacing={{ xs: 2, md: 3 }}
      columns={{ xs: 2, sm: 8, md: 12 }}
    >
      {cards.map((card) => (
        <Grid item xs={2} sm={4} md={6} key={card.id} sx={{ p: 1 }}>
          <Card sx={{ position: 'relative' }}>
            <Box
              sx={{
                display: 'flex',
                flexDirection: 'column',
                gap: 2,
                width: 70,
                position: 'absolute',
                top: 20,
                right: 20,
              }}
            >
              {card.habitat?.map((hab) => (
                <Habitat habitat={hab} key={hab} />
              ))}
            </Box>
            <CardMedia
              component='img'
              sx={{ p: 2, borderRadius: 5, height: 500 }}
              image={card.imagem}
              alt={`Imagem de um ${card.nomePt}`}
            />
            <CardContent sx={{ flexGrow: 1 }}>
              <Typography gutterBottom variant='h5' component='h2'>
                {card.nomeLt}, {card.nomePt}
              </Typography>
              <Typography>
                {card.nomeEn}, {card.familia}, {card.tamanho} cm
              </Typography>
            </CardContent>
          </Card>
        </Grid>
      ))}
    </Grid>
  );
};

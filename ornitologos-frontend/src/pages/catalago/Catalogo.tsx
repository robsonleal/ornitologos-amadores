import {
  Box,
  Card,
  CardContent,
  CardMedia,
  Grid,
  LinearProgress,
  Pagination,
  Paper,
  Typography,
} from '@mui/material';
import { useEffect, useMemo, useState } from 'react';
import { useSearchParams } from 'react-router-dom';
import { BarraDeFerramentas, Habitat } from '../../shared/components';
import { Enviroment } from '../../shared/environment';
import { useDebounce } from '../../shared/hooks';
import { LayoutBaseDePagina } from '../../shared/layouts';
import { IListagemAve } from '../../shared/models';
import { AvesService } from '../../shared/services/api/aves/AvesService';

export const Catalago = () => {
  const [searchParams, setSearchParams] = useSearchParams();
  const { debounce } = useDebounce();
  const [cards, setCards] = useState<IListagemAve[]>([]);
  const [totalCount, setTotalCount] = useState(0);
  const [isLoading, setIsLoading] = useState(true);

  const busca = useMemo(() => {
    return searchParams.get('busca') || '';
  }, [searchParams]);

  const pagina = useMemo(() => {
    return Number(searchParams.get('pagina') || '1');
  }, [searchParams]);

  useEffect(() => {
    setIsLoading(true);
    debounce(() => {
      AvesService.getAll(pagina, busca).then((result) => {
        setIsLoading(false);
        if (result instanceof Error) {
          alert(result.message);
        } else {
          console.log(result);
          setCards(result.data);
          setTotalCount(result.totalCount);
        }
      });
    });
  }, [busca, pagina]);

  return (
    <LayoutBaseDePagina
      titulo='Catálogo'
      barraDeFerramentas={
        <BarraDeFerramentas
          textoDaBusca={busca}
          aoMudarTextoDeBusca={(texto) =>
            setSearchParams({ busca: texto, pagina: '1' }, { replace: true })
          }
        />
      }
    >
      {isLoading && (
        <Box>
          <LinearProgress variant='indeterminate' sx={{ m: 1 }} />
        </Box>
      )}
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
                  width: 55,
                  position: 'absolute',
                  bottom: 125,
                  right: 25,
                }}
              >
                {card.habitat?.map((hab) => (
                  <Box
                    key={hab}
                    sx={{
                      background: 'rgba(255, 255, 255, 0.4)',
                      borderRadius: 100,
                    }}
                  >
                    <Habitat habitat={hab} />
                  </Box>
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
      {totalCount === 0 && !isLoading && (
        <Box component={Paper} elevation={3} sx={{ p: 3, m: 3 }}>
          <Typography variant='h6'>{Enviroment.LISTAGEM_VAZIA}</Typography>
        </Box>
      )}
      {totalCount > Enviroment.LIMITE_AVES && (
        <Box sx={{ p: 3, m: 3, display: 'flex', justifyContent: 'center' }}>
          <Pagination
            count={Math.ceil(totalCount / Enviroment.LIMITE_AVES)}
            page={pagina}
            variant='outlined'
            color='primary'
            onChange={(_, newPag) =>
              setSearchParams(
                { busca, pagina: newPag.toString() },
                { replace: true }
              )
            }
          />
        </Box>
      )}
    </LayoutBaseDePagina>
  );
};

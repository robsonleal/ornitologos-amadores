import {
  Box,
  Button,
  CircularProgress,
  Divider,
  Grid,
  Icon,
  Paper,
  TextField,
  Typography,
} from '@mui/material';
import { ChangeEvent, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import * as yup from 'yup';
import { IDetalheAvistamento } from '../../models';

const loginSchema = yup.object().shape({
  data: yup.string().required(),
  horario: yup.string().required(),
  local: yup.string().required().min(3),
  ave: yup.string().required(),
});

interface IModalFormProps {
  closeModal: () => void;
}

export const ModalForm: React.FC<IModalFormProps> = ({ closeModal }) => {
  const [loading, setLoading] = useState(false);
  const navigate = useNavigate();

  const [errorsState, setErrorsState] = useState<IDetalheAvistamento>({
    data: '',
    horario: '',
    local: '',
    ave: '',
  });

  const [avistamento, setAvistamento] = useState<IDetalheAvistamento>({
    data: '',
    horario: '',
    local: '',
    ave: '',
  });

  function updateModel(e: ChangeEvent<HTMLInputElement>) {
    setAvistamento({
      ...avistamento,
      [e.target.name]: e.target.value,
    });
  }
  const handleSubmit = (event: ChangeEvent<HTMLFormElement>) => {
    event.preventDefault();

    setLoading(true);

    loginSchema
      .validate(avistamento, { abortEarly: false })
      .then((dadosValidos) => {
        console.log(dadosValidos);
        /*cadastroUsuario(dadosValidos).then(() => {
          setLoading(false);
          navigate('/login');
        });*/
      })
      .catch((errors: yup.ValidationError) => {
        setLoading(false);
        errors.inner.forEach((error) => {
          if (error.path === 'data') {
            setErrorsState((e) => ({ ...e, data: error.message }));
          } else if (error.path === 'horario') {
            setErrorsState((e) => ({ ...e, horario: error.message }));
          } else if (error.path === 'local') {
            setErrorsState((e) => ({ ...e, local: error.message }));
          } else if (error.path === 'ave') {
            setErrorsState((e) => ({ ...e, ave: error.message }));
          }
        });
      });
  };

  return (
    <Box
      sx={{
        marginTop: 8,
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
      }}
    >
      <Box component={Paper} padding={10}>
        <Box sx={{ display: 'flex', justifyContent: 'space-between' }}>
          <Typography variant='h5'>Novo avistamento</Typography>
          <Button onClick={closeModal} endIcon={<Icon>arrow_back</Icon>}>
            Voltar
          </Button>
        </Box>
        <Divider />
        <Box component='form' noValidate onSubmit={handleSubmit} sx={{ mt: 3 }}>
          <Grid container spacing={2}>
            <Grid item xs={12}>
              <TextField
                autoComplete='given-data'
                name='data'
                required
                fullWidth
                id='data'
                type='date'
                label='Data'
                autoFocus
                disabled={loading}
                error={!!errorsState.data}
                helperText={errorsState.data}
                onKeyDown={() => setErrorsState((e) => ({ ...e, data: '' }))}
                onChange={(e: ChangeEvent<HTMLInputElement>) => updateModel(e)}
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                id='horario'
                label='Horario'
                type='time'
                name='horario'
                autoComplete='horario'
                disabled={loading}
                error={!!errorsState.horario}
                helperText={errorsState.horario}
                onKeyDown={() => setErrorsState((e) => ({ ...e, horario: '' }))}
                onChange={(e: ChangeEvent<HTMLInputElement>) => updateModel(e)}
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                name='local'
                label='Local'
                id='local'
                autoComplete='local'
                disabled={loading}
                error={!!errorsState.local}
                helperText={errorsState.local}
                onKeyDown={() => setErrorsState((e) => ({ ...e, local: '' }))}
                onChange={(e: ChangeEvent<HTMLInputElement>) => updateModel(e)}
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                name='ave'
                label='Ave'
                id='ave'
                autoComplete='ave'
                disabled={loading}
                error={!!errorsState.ave}
                helperText={errorsState.ave}
                onKeyDown={() => setErrorsState((e) => ({ ...e, ave: '' }))}
                onChange={(e: ChangeEvent<HTMLInputElement>) => updateModel(e)}
              />
            </Grid>
          </Grid>
          <Box sx={{ m: 1, position: 'relative' }}>
            <Button
              type='submit'
              fullWidth
              variant='contained'
              color='secondary'
              disabled={loading}
              sx={{ my: 3 }}
            >
              Enviar
            </Button>
            {loading && (
              <CircularProgress
                size={24}
                sx={{
                  color: 'outlined',
                  position: 'absolute',
                  top: '50%',
                  left: '50%',
                  marginTop: '-12px',
                  marginLeft: '-12px',
                }}
              />
            )}
          </Box>
        </Box>
      </Box>
    </Box>
  );
};

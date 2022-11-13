import {
  Box,
  Button,
  CircularProgress,
  Grid,
  Link,
  TextField,
} from '@mui/material';
import { ChangeEvent, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import * as yup from 'yup';
import { Copyright } from '../../shared/components';
import { LayoutBaseDePaginaInicial } from '../../shared/layouts';
import { Usuario } from '../../shared/models';
import { cadastroUsuario } from '../../shared/services/api/usuario/UsuarioService';

const loginSchema = yup.object().shape({
  nome: yup.string().required(),
  email: yup.string().email().required(),
  senha: yup.string().required().min(3),
});

export function SignUp() {
  const [loading, setLoading] = useState(false);
  const navigate = useNavigate();

  const [errorsState, setErrorsState] = useState<Usuario>({
    nome: '',
    email: '',
    senha: '',
  });

  const [user, setUser] = useState<Usuario>({
    nome: '',
    email: '',
    senha: '',
  });

  function updateModel(e: ChangeEvent<HTMLInputElement>) {
    setUser({
      ...user,
      [e.target.name]: e.target.value,
    });
  }

  const handleSubmit = (event: ChangeEvent<HTMLFormElement>) => {
    event.preventDefault();

    setLoading(true);

    loginSchema
      .validate(user, { abortEarly: false })
      .then((dadosValidos) => {
        cadastroUsuario(dadosValidos).then(() => {
          setLoading(false);
          navigate('/login');
        });
      })
      .catch((errors: yup.ValidationError) => {
        setLoading(false);
        errors.inner.forEach((error) => {
          if (error.path === 'nome') {
            setErrorsState((e) => ({ ...e, nome: error.message }));
          } else if (error.path === 'email') {
            setErrorsState((e) => ({ ...e, email: error.message }));
          } else if (error.path === 'senha') {
            setErrorsState((e) => ({ ...e, senha: error.message }));
          }
        });
      });
  };

  const handleClickNavigate = (to: string) => {
    navigate(to);
  };

  return (
    <LayoutBaseDePaginaInicial titulo='Cadastre-se'>
      <Box
        sx={{
          marginTop: 8,
          display: 'flex',
          flexDirection: 'column',
          alignItems: 'center',
        }}
      >
        <Box component='form' noValidate onSubmit={handleSubmit} sx={{ mt: 3 }}>
          <Grid container spacing={2}>
            <Grid item xs={12}>
              <TextField
                autoComplete='given-name'
                name='nome'
                required
                fullWidth
                id='nome'
                label='Nome'
                autoFocus
                disabled={loading}
                error={!!errorsState.nome}
                helperText={errorsState.nome}
                onKeyDown={() => setErrorsState((e) => ({ ...e, nome: '' }))}
                onChange={(e: ChangeEvent<HTMLInputElement>) => updateModel(e)}
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                id='email'
                label='Email'
                name='email'
                autoComplete='email'
                disabled={loading}
                error={!!errorsState.email}
                helperText={errorsState.email}
                onKeyDown={() => setErrorsState((e) => ({ ...e, email: '' }))}
                onChange={(e: ChangeEvent<HTMLInputElement>) => updateModel(e)}
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                name='senha'
                label='Senha'
                type='password'
                id='senha'
                autoComplete='new-password'
                disabled={loading}
                error={!!errorsState.senha}
                helperText={errorsState.senha}
                onKeyDown={() => setErrorsState((e) => ({ ...e, senha: '' }))}
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
              Cadastrar-se
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
          <Grid container justifyContent='flex-end'>
            <Grid item>
              <Link
                onClick={() => handleClickNavigate('/login')}
                variant='body2'
                sx={{ cursor: 'pointer' }}
              >
                Já tem uma conta? Entrar
              </Link>
            </Grid>
          </Grid>
        </Box>
      </Box>
      <Copyright />
    </LayoutBaseDePaginaInicial>
  );
}

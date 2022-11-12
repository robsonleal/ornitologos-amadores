import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import CircularProgress from '@mui/material/CircularProgress';
import Grid from '@mui/material/Grid';
import Link from '@mui/material/Link';
import TextField from '@mui/material/TextField';
import { ChangeEvent, useEffect, useRef, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import Usuario from '../../models/Usuario';
import { Copyright } from '../../shared/components/Copyright';
import { LayoutBaseDePaginaInicial } from '../../shared/layouts';
import { cadastroUsuario } from '../../shared/services/api/usuario/UsuarioService';

export function SignUp() {
  const [loading, setLoading] = useState(false);
  const navigate = useNavigate();
  const timer = useRef<number>();

  const [userResult, setUserResult] = useState<Usuario>({
    nome: '',
    email: '',
    senha: '',
  });

  const [user, setUser] = useState<Usuario>({
    nome: '',
    email: '',
    senha: '',
  });

  useEffect(() => {
    ('');
  }, [userResult]);

  function updateModel(e: ChangeEvent<HTMLInputElement>) {
    setUser({
      ...user,
      [e.target.name]: e.target.value,
    });
  }

  const handleSubmit = (event: ChangeEvent<HTMLFormElement>) => {
    event.preventDefault();

    setLoading(true);

    if (!loading) {
      timer.current = window.setTimeout(() => {
        cadastroUsuario(user, setUserResult);
        setLoading(false);
      }, 2000);
    }
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

import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import Link from '@mui/material/Link';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import {ThemeProvider, useTheme } from '@mui/material/styles';
import Usuario from '../models/Usuario';
import { ChangeEvent, useEffect, useRef, useState } from 'react';
import { cadastroUsuario } from '../shared/services/api/Service';
import CircularProgress from '@mui/material/CircularProgress';

export default function SignUp() {

  const theme = useTheme();

  const [loading, setLoading] = useState(false);
  const timer = useRef<number>();

  const [userResult, setUserResult] = useState<Usuario>(
    {
        nome: '',
        email: '',
        senha: ''
    })


    const [user, setUser] = useState<Usuario>(
      {
          nome: '',
          email: '',
          senha: ''
      })
  
  const buttonSx = {
    ...({
      '&:hover': {
        bgcolor: 'outlined'
      },
      mt:3,
      mb:2
    }),
  };

    useEffect(() => {
  }, [userResult])


  function updateModel(e: ChangeEvent<HTMLInputElement>) {

    setUser({
        ...user,
        [e.target.name]: e.target.value
    })

}

  const handleSubmit = (event: ChangeEvent<HTMLFormElement>) => {
    event.preventDefault();

     setLoading(true);

    if (!loading) {
      timer.current = window.setTimeout(() => {
        cadastroUsuario(`/api/v1/auth/cadastro`, user,setUserResult);
        setLoading(false);
      }, 2000);
    }

  };

  return (
    <ThemeProvider theme={theme}>
      <Container component="main" maxWidth="xs">
        <CssBaseline />
        <Box
          sx={{
            marginTop: 8,
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
          }}
        >
         <Avatar sx={{ m: 1, bgcolor: "#FFFFFF"}} src="/icon.svg"/>
          <Typography component="h1" variant="h5">
            Cadastrar-se
          </Typography>
          <Box component="form" noValidate onSubmit={handleSubmit} sx={{ mt: 3 }}>
            <Grid container spacing={2}>
              <Grid item xs={12}>
                <TextField
                  autoComplete="given-name"
                  name="nome"
                  required
                  fullWidth
                  id="nome"
                  label="Nome"
                  autoFocus
                  onChange={(e: ChangeEvent<HTMLInputElement>) => updateModel(e)}
                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  required
                  fullWidth
                  id="email"
                  label="Email"
                  name="email"
                  autoComplete="email"
                  onChange={(e: ChangeEvent<HTMLInputElement>) => updateModel(e)}
                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  required
                  fullWidth
                  name="senha"
                  label="Senha"
                  type="password"
                  id="senha"
                  autoComplete="new-password"
                  onChange={(e: ChangeEvent<HTMLInputElement>) => updateModel(e)}
                />
              </Grid>
            </Grid>
            <Box sx={{ m: 1, position: 'relative' }}>
            <Button
              type="submit"
              fullWidth
              variant="contained"
              sx={buttonSx}
              disabled={loading}
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
            <Grid container justifyContent="flex-end">
              <Grid item>
                <Link href="/login" variant="body2">
                 Já tem uma conta? Entrar
                </Link>
              </Grid>
            </Grid>
          </Box>
        </Box>
      </Container>
    </ThemeProvider>
  );
}
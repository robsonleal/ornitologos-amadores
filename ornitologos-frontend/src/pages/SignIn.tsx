import * as React from 'react';
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
import UsuarioLogin from '../models/UsuarioLogin';
import { ChangeEvent, useEffect, useRef, useState } from 'react';
import { fazerLogin } from '../shared/services/api/Service';
import { CircularProgress } from '@mui/material';

function Copyright(props: any) {
  return (
    <Typography variant="body2" color="text.secondary" align="center" {...props}>
      {'Copyright © '}
        Ornitologos amadores, 
      {new Date().getFullYear()}
      {'.'}
    </Typography>
  );
}

export default function SignIn() {

const theme = useTheme();

const [loading, setLoading] = useState(false);
const timer = useRef<number>();

const [userResult, setUserResult] = useState<UsuarioLogin>(
  {
      email: '',
      senha: ''
  })


  const [user, setUser] = useState<UsuarioLogin>(
    {
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
  

  const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    setLoading(true);

    console.log(user)
    if (!loading) {
      timer.current = window.setTimeout(() => {
        fazerLogin(`/api/v1/auth/login`, user,setUserResult);
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
          <Typography component={Box} variant="h5">
            Fazer login
          </Typography>
          <Box component="form" onSubmit={handleSubmit} noValidate sx={{ mt: 1 }}>
            <TextField
              margin="normal"
              required
              fullWidth
              id="email"
              label="Email"
              name="email"
              autoComplete="email"
              autoFocus
              onChange={(e: ChangeEvent<HTMLInputElement>) => updateModel(e)}
            />
            <TextField
              margin="normal"
              required
              fullWidth
              name="senha"
              label="Senha"
              type="password"
              id="senha"
              autoComplete="current-password"
              onChange={(e: ChangeEvent<HTMLInputElement>) => updateModel(e)}
            />
             <Box sx={{ m: 1, position: 'relative' }}>
              
             <Button
              type="submit"
              fullWidth
              sx={buttonSx}
              variant="contained"
              disabled={loading}
            >
              Entrar
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
            <Grid container>
              <Grid item>
                <Link href="/cadastro" variant="body2">
                  {"Não tem uma conta? Cadastre-se"}
                </Link>
              </Grid>
            </Grid>
          </Box>
        </Box>
        <Copyright sx={{ mt: 8, mb: 4 }} />
      </Container>
   </ThemeProvider>
  );
}